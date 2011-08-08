package
{
	import flash.events.MouseEvent;
	import flash.events.TouchEvent;
	import flash.geom.Point;
	import flash.ui.Multitouch;
	import flash.ui.MultitouchInputMode;
	
	import net.flashpunk.Entity;
	import net.flashpunk.FP;
	import net.flashpunk.Graphic;
	import net.flashpunk.Mask;
	import net.flashpunk.graphics.Image;
	import net.flashpunk.utils.Input;
	import net.flashpunk.utils.Key;
	
	public class Player extends Entity
	{
		[Embed(source = 'assets/player.png')] private const PLAYER_GRAPHIC:Class;
		public var image:Image;
		private var _v:Point;
		public var leftPressed:Boolean;
		public var rightPressed:Boolean;
		public var upPressed:Boolean;
		public var downPressed:Boolean;
		
		public function Player(_x:int, _y:int)
		{
			image = new Image(PLAYER_GRAPHIC);
			graphic = image;
			setHitbox(24,24,0,0);
			type = "player";
			_v = new Point;
			this.x = _x;
			this.y = _y;
			
			Multitouch.inputMode = MultitouchInputMode.TOUCH_POINT;
			
			FP.stage.addEventListener(TouchEvent.TOUCH_BEGIN, screenPressed);
			FP.stage.addEventListener(TouchEvent.TOUCH_END, screenReleased);
			FP.stage.addEventListener(MouseEvent.MOUSE_DOWN, screenClicked);
			FP.stage.addEventListener(MouseEvent.MOUSE_UP, screenUnclicked);
		}
		
		private function screenReleased(event:TouchEvent):void
		{
			leftPressed = false;
			rightPressed = false;
			upPressed = false;
			downPressed = false;
			
		}

		private function screenUnclicked(event:MouseEvent):void
		{
			leftPressed = false;
			rightPressed = false;
			upPressed = false;
			downPressed = false;
			
		}

		private function screenPressed(event:TouchEvent):void
		{
			if(event.stageY > 600)
			{
				if(event.stageX >= 0 && event.stageX < 120)
					leftPressed = true;
				if(event.stageX >= 120 && event.stageX < 240)
					rightPressed = true;
				if(event.stageX >= 240 && event.stageX < 360)
					upPressed = true;
				if(event.stageX >= 360 && event.stageX < 480)
					downPressed = true;
			}
		}
		
		private function screenClicked(event:MouseEvent):void
		{
			if(event.stageY > 600)
			{
				if(event.stageX >= 0 && event.stageX < 120)
					leftPressed = true;
				if(event.stageX >= 120 && event.stageX < 240)
					rightPressed = true;
				if(event.stageX >= 240 && event.stageX < 360)
					upPressed = true;
				if(event.stageX >= 360 && event.stageX < 480)
					downPressed = true;
			}
		}
		
		override public function update():void
		{
			updatemovement();
			updateCollision();
		}
		
		private function updatemovement():void
		{
			var movement:Point = new Point;
			if(Input.check(Key.RIGHT) || rightPressed)
			{	
				movement.x++;
				//rightPressed = false;
			}
			if(Input.check(Key.LEFT) || leftPressed)
			{
				movement.x--;
				//leftPressed = false;
			}
			if(Input.check(Key.UP) || upPressed)
			{
				movement.y--;
				//upPressed = false;
			}
			if(Input.check(Key.DOWN) || downPressed)
			{
				movement.y++;
				//downPressed = false;
			}
			
			_v.x = 48 * FP.elapsed * movement.x;
			_v.y = 48 * FP.elapsed * movement.y;
		}
		
		private function updateCollision():void
		{
			x += _v.x;
			
			if(collide("level",x,y))
			{
				if(FP.sign(_v.x) > 0)
				{
					_v.x = 0;
					x = Math.floor(x / 24) * 24 + 24 - width;
				}
				else
				{
					_v.x = 0;
					x = Math.floor(x / 24) * 24 + 24;
				}
			}

			y += _v.y;
			
			if(collide("level",x,y))
			{
				if(FP.sign(_v.y) > 0)
				{
					_v.y = 0;
					y = Math.floor(y / 24) * 24 + 24 - height;
				}
				else
				{
					_v.y = 0;
					y = Math.floor(y / 24) * 24 + 24;
				}
			}
		}
	}
}