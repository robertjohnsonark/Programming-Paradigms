public class SpriteMover implements Runnable
{
	Model model;
	View view;
	
	public SpriteMover(Model model, View view)
	{
		this.model = model;
		this.view = view;
	}

	public void run() 
	{
	
		while(true)
		{
			
			model.updateScene( view.getHeight(), view.getWidth() );
			view.repaint();
		
			try
			{
				Thread.sleep(2);
			}
			catch( InterruptedException e) {}
		}
	}
}