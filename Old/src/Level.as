package
{
	import flash.utils.ByteArray;
	
	import net.flashpunk.Entity;
	import net.flashpunk.Graphic;
	import net.flashpunk.Mask;
	import net.flashpunk.graphics.Tilemap;
	import net.flashpunk.masks.Grid;
	
	public class Level extends Entity
	{
		private var _tiles:Tilemap;
		private var _grid:Grid;
		public var LevelData:XML;
		
		public function Level(xml:Class)
		{
			_tiles = new Tilemap(Assets.TILES_GRAPHIC, 480, 600, 24, 24);
			graphic = _tiles;
			layer = 1;
			
					
			_grid = new Grid(480, 600, 24, 24, 0, 0);
			mask = _grid;
			
			loadLevel(xml);
			
			type = "level";
		}
		
		private function loadLevel(xml:Class):void
		{
			var rawData:ByteArray = new xml;
			var dataString:String = rawData.readUTFBytes(rawData.length);
			LevelData = new XML(dataString);
			
			var dataList:XMLList;
			var dataElement:XML;
			
			dataList = LevelData.tiles.tile;
			
			for each(dataElement in dataList)
			{
				_tiles.setTile(int(dataElement.@x)/24, int(dataElement.@y)/24, int(dataElement.@tx)/24);
				_grid.setTile(int(dataElement.@x)/24, int(dataElement.@y)/24, (int(dataElement.@tx)/24 == 1));
			}
		}
	}
}