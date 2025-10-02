package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassUpdater implements ItemUpdaterStrategy {
    @Override
    public void update(Item item) {
        int increment = 1;
        if (item.sellIn < 11) increment++;
        if (item.sellIn < 6)  increment++;

        item.quality = Math.min(50, item.quality + increment);

        item.sellIn--;
        if(item.sellIn < 0){
            item.quality = 0;
        }

    }
}
