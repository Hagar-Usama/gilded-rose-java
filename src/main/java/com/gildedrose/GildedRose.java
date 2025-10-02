package com.gildedrose;
import static com.gildedrose.ItemTypes.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            if(item.name.equals(BACKSTAGE_PASSES) ){
                        int increment = 0;
                        if (item.sellIn < 11) increment++;
                        if (item.sellIn < 6)  increment++;
                        item.quality = Math.min(50, item.quality + increment);
                        item.quality = Math.min(50, item.quality + 1);
                        item.sellIn = item.sellIn - 1;

            }else if(item.name.equals(AGED_BRIE)){
                item.quality = Math.min(50, item.quality + 1);
                item.sellIn = item.sellIn - 1;
            }else if(item.name.equals(SULFURAS)){
                item.quality = Math.max(80, item.quality);
            }else{

                 item.quality = Math.max(0, item.quality - 1);
                 item.sellIn = item.sellIn - 1;
            }


            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    item.quality = Math.min(50, item.quality + 1);
                } else if (item.name.equals(BACKSTAGE_PASSES)) {
                    item.quality = 0;
                } else if (!item.name.equals(SULFURAS)) {
                    item.quality = Math.max(0, item.quality - 1);
                }
            }
        }
    }
}