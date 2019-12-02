package fr.fireowls.spaceowls.engine;

public class EngineLoop implements Runnable {

    protected Engine engine;

    protected long startNanoTime = 1;
    protected long lastTime = 0;

    protected double timer = 0;
    protected double delta = 0;
    
    private boolean running;
    
    private Thread thread;
    
    public EngineLoop(Engine engine) {
		this.engine = engine;
		this.running = false;
		thread = new Thread(this);
	}

	public double getDeltaTime() {
        return delta;
    }

    public double getClock() {
        return timer;
    }

    public Engine getEngine() {
        return engine;
    }
    
    public void start() {
    	running = true;
    	thread.start();
    }
    
    public void stop() {
    	running = false;
    	try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void run() {
		lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		timer = System.currentTimeMillis();
		int frames = 0;
		
		engine.create();
		
		while(running) {
			long now = System.nanoTime();		
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				engine.update(delta);
				delta--;
			}
			if(running)
				//engine.render(engine.getPainter());
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		engine.dispose();
	}
}
