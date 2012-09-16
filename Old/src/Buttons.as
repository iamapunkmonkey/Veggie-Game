package
{
	import net.flashpunk.Entity;
	import net.flashpunk.Graphic;
	import net.flashpunk.Mask;
	import net.flashpunk.graphics.Image;
	
	public class Buttons extends Entity
	{
		[Embed(source = 'assets/buttons.png')] 
		public static const BUTTONS_GRAPHIC:Class;
		
		private var img:Image
		public function Buttons(x:Number=0, y:Number=0, graphic:Graphic=null, mask:Mask=null)
		{
			img = new Image(BUTTONS_GRAPHIC);
			graphic = img;
			x = 0;
			y = 600;
			this.layer = 0;
		}
	}
}