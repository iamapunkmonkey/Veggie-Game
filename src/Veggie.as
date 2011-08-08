package
{
	
	import net.flashpunk.Engine;
	import net.flashpunk.FP;
	
	import splash.Splash;
	
	public class Veggie extends Engine
	{
		public function Veggie()
		{
			super(480,800);
			//FP.console.enable();
			
		}
		
		override public function init():void
		{
			
			//super.init();
			//FP.world = new GameWorld();
			var s:Splash = new Splash;
			FP.world.add(s);
			s.start(splashComplete);
		}
		
		public function splashComplete():void
		{
			FP.world = new GameWorld();
		}
	}
}