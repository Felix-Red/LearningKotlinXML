package com.example.livedrawing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceView

class LiveDrawingView(context: Context, mScreenX: Int):SurfaceView(context), Runnable {

    private val debugging = true

    private val particleSystems = ArrayList<ParticleSystem>()

    private var nextSystem = 0
    private val maxSystems = 1000
    private val particlesPerSystem = 100

    private lateinit var thread: Thread

    //these objects are needed to do the drawing
    private lateinit var canvas: Canvas
    private val paint: Paint = Paint()

    private var fps: Long = 0

    private val millisInSecond: Long = 1000

    //how big will the text be?
    //Font is 5% (1/20th) of screen width
    //Margin is 1.5% (1/75th) of the screen width

    private val fontSize: Int = mScreenX / 20
    private val fontMargin: Int = mScreenX / 75


    @Volatile
    private var drawing: Boolean = false
    private var paused = true

    private var resetButton: RectF
    private var togglePauseButton: RectF


    init {
        resetButton = RectF(0f, 0f, 100f, 100f)
        togglePauseButton = RectF(0f, 150f, 100f, 250f)

        // Initialize the particles and their systems
        for (i in 0 until maxSystems) {
            particleSystems.add(ParticleSystem())
            particleSystems[i]
                .initParticles(particlesPerSystem)
        }
    }

    private fun draw(){

        if(holder.surface.isValid){
            canvas = holder.lockCanvas()

            canvas.drawColor(Color.argb(255, 0, 0, 0))

            paint.color = Color.argb(255, 255, 255, 255)

            paint.textSize = fontSize.toFloat()

            //Draw the particle systems
            for (i in 0 until nextSystem) {
                particleSystems[i].draw(canvas, paint)
            }
            //Draw the HUD
            canvas.drawRect(resetButton, paint)
            canvas.drawRect(togglePauseButton, paint)

            if(debugging){
                printDebuggingText()
            }

            //Display the drawing on screen
            //unlockCanvasAndPost is a function of surfaceHolder

            holder.unlockCanvasAndPost(canvas)
        }

    }

    private fun printDebuggingText(){
        val debugSize = fontSize / 2
        val debugStart = 150
        paint.textSize = debugSize.toFloat()

        canvas.drawText("fps: $fps", 10f, (debugStart + debugSize).toFloat(), paint)

        canvas.drawText("Systems: $nextSystem",
            10f, (fontMargin + debugStart +
                    debugSize * 2).toFloat(), paint)

        canvas.drawText("Particles: ${nextSystem *
                particlesPerSystem}",
            10f, (fontMargin + debugStart
                    + debugSize * 3).toFloat(), paint)
        
    }

    override fun run() {
        // The drawing Boolean gives us finer control
        // rather than just relying on the calls to run
        // drawing must be true AND
        // the thread running for the main
        // loop to execute

        while (drawing){
            val frameStartTime = System.currentTimeMillis()

            if(!paused){
                update()
            }

            draw()

            val timeThisFrame = System.currentTimeMillis() - frameStartTime
            // Make sure timeThisFrame is
            // at least 1 millisecond
            // because accidentally dividing
            // by zero crashes the app

            if(timeThisFrame > 0){
                // Store the current frame rate in fps
                // ready to pass to the update functions of
                // of our particles in the next frame/loop
                fps = millisInSecond / timeThisFrame
            }
        }
    }

    //This function is called by MainActivity when the user quits the app
    fun pause(){
        drawing = false
        try{
            thread.join()
        }catch (e: InterruptedException){
            Log.e("Error: ", "Joining thread")
        }
    }

    //this function is called by MainActivity when the player starts the app

    fun resume(){
        drawing = true

        thread = Thread(this)

        thread.start()
    }

    private fun update(){
        //update the particles
        for (i in 0 until particleSystems.size) {
            if (particleSystems[i].isRunning) {
                particleSystems[i].update(fps)
            }
        }
    }

    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        // User moved a finger while touching screen
        if (motionEvent.action and MotionEvent.
            ACTION_MASK ==
            MotionEvent.ACTION_MOVE) {

            particleSystems[nextSystem].emitParticles(
                PointF(motionEvent.x,
                    motionEvent.y)
            )

            nextSystem++
            if (nextSystem == maxSystems) {
                nextSystem = 0
            }
        }

        // Did the user touch the screen
        if (motionEvent.action and MotionEvent.ACTION_MASK ==
            MotionEvent.ACTION_DOWN) {

            // User pressed the screen so let's
            // see if it was in the reset button
            if (resetButton.contains(motionEvent.x,
                    motionEvent.y)) {

                // Clear the screen of all particles
                nextSystem = 0
            }

            // User pressed the screen so let's
            // see if it was in the toggle button
            if (togglePauseButton.contains(motionEvent.x,
                    motionEvent.y)) {

                paused = !paused
            }
        }
        return true
    }
}