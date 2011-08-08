package
{
	import flash.display.BitmapData;
	
	import net.flashpunk.Entity;
	import net.flashpunk.FP;
	import net.flashpunk.World;
	import net.flashpunk.graphics.Image;
	import net.flashpunk.utils.Input;
	
	public class GameWorld extends World
	{
		[Embed(source="assets/testlevel.oel", mimeType = "application/octet-stream")]
		private static const DEFAULT_MAP:Class;
		
		public function GameWorld()
		{
			
		}
		
		override public function begin():void
		{
			//add(new Buttons);
			
			var level:Level = new Level(DEFAULT_MAP);
			
			var dataList:XMLList;
			var dataElement:XML;
			
			dataList = level.LevelData.objects.playerStart;
			
			for each(dataElement in dataList)
			{
				add(new Player(int(dataElement.@x), int(dataElement.@y)));
			}
			
			dataList = level.LevelData.objects.EnemyStart;
			
			for each(dataElement in dataList)
			{
				add(new Enemy(int(dataElement.@x), int(dataElement.@y)));
			}
			
			add(level);
			super.begin();
		}

		override public function update():void
		{
			super.update();
		}
	}
}