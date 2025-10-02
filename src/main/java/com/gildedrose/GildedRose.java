package com.gildedrose;

import com.gildedrose.updaters.*;
import java.util.Map;
import static com.gildedrose.ItemTypes.*;



class GildedRose {
    Item[] items;
    private final Map<String, ItemUpdaterStrategy> updaters;

    public GildedRose(Item[] items) {
        this.items = items;
        this.updaters = Map.of(
            AGED_BRIE, new AgedBrieUpdater(),
            BACKSTAGE_PASSES, new BackstagePassUpdater(),
            SULFURAS, new SulfurasUpdater()
        );
    }

        
    public void updateQuality() {

        for (Item item : items) {
            ItemUpdaterStrategy updater = updaters.getOrDefault(item.name, new NormalItemUpdater());
            updater.update(item);
        }
    }

}