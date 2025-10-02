package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater implements ItemUpdaterStrategy {
    @Override
    public void update(Item item) {
        item.quality = Math.min(50, item.quality + 1);
        
        item.sellIn--;
        if(item.sellIn < 0){
            item.quality = Math.min(50, item.quality + 1);
        }
    }
}
