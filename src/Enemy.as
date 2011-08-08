package
{
	import net.flashpunk.Entity;
	import net.flashpunk.FP;
	import net.flashpunk.Graphic;
	import net.flashpunk.Mask;
	import net.flashpunk.graphics.Image;

	
	public class Enemy extends Entity
	{
		[Embed(source = 'assets/enemy.png')] private const ENEMY_GRAPHIC:Class;
		public var image:Image;
		
		public function Enemy(_x:int, _y:int)
		{
			image = new Image(ENEMY_GRAPHIC);
			graphic = image;
			setHitbox(24,72,0,0);
			x = FP.rand(FP.screen.width);
			y = FP.rand(FP.screen.height);
			type = "enemy";
			this.x = _x;
			this.y = _y;
		}
	}
}