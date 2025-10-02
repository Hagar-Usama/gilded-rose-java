package com.gildedrose;
import static com.gildedrose.ItemTypes.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
           
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(BACKSTAGE_PASSES)) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality = Math.max(0, item.quality - 1);
                    }
            } else {
                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            item.quality = Math.min(50, item.quality + 1);
                        }

                        if (item.sellIn < 6) {
                            item.quality = Math.min(50, item.quality + 1);
                        }
                    }
                    
                    item.quality = Math.min(50, item.quality + 1);
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality = Math.max(0, item.quality - 1);
                            }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    item.quality = Math.min(50, item.quality + 1);
                }
            }
        }
    }
}