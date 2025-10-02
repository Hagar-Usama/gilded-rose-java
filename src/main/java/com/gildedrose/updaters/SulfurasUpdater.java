package com.gildedrose.updaters;

import com.gildedrose.Item;

public class SulfurasUpdater implements ItemUpdaterStrategy{
    @Override
    public void update(Item item) {
        item.quality = Math.max(80, item.quality);
    }
}
