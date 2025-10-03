package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    /* General/Normal Item Tests */ 
    @Test
    void normalItemShouldDecreaseQualityByOne_whenSellInAboveZero(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 5, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(24, app.items[0].quality);
    }


    // Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void normalItemShouldDecreaseQualityByTwo_whenSellInZeroOrLess(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 0, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(23, app.items[0].quality);

    }


    //  The Quality of an item is never negative
    @Test
    void itemShouldNotDecreaseQualityBelowZero(){
        // Arrange
        Item[] items = new Item[] { new Item("foo", 5, 0) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(0, app.items[0].quality);
    }


 
    /* Aged Brie Tests */ 

    // "Aged Brie" actually increases in Quality the older it gets
    @Test
    void agedBrieShouldIncreaseQualityByOne_whenSellInAboveZero(){
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 5, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(26, app.items[0].quality);
        // assert((app.items[0].quality) > 25);
    }

       // The Quality of an item is never more than 50
    @Test
    void itemShouldNotIncreaseQualityAboveFifty(){
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void agedBrieShouldIncreaseQualityByTwo_whenExpired() {
        // Arrange
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();

        // Assert
        assertEquals(42, app.items[0].quality);
    }


    /* Sulfuras Tests */ 

    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    // an item can never have its Quality increase above 50,
    // however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
    @Test
    void itemShouldNotChangeQualityOrSellIn_whenSulfuras(){
        // Arrange
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }


    /* Backstage Passes Tests */
    
    // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    @Test
    void backstagePassesShouldIncreaseQualityByOne_whenSellInAboveTen(){
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(26, app.items[0].quality);
    }

    // quality increases by 2 when there are 10 days or less 
    @Test
    void backstagePassesShouldIncreaseQualityByTwo_whenSellInBetweenSixAndTen(){
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(27, app.items[0].quality);
    }

    //and by 3 when there are 5 days or less 
    @Test
    void backstagePassesShouldIncreaseQualityByThree_whenSellInBetweenOneAndFive(){
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(28, app.items[0].quality);
    }


    // but quality drops to 0 after the concert
    @Test
    void backstagePassesShouldDropQualityToZero_whenSellInZeroOrLess(){
        // Arrange
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(0, app.items[0].quality);
    }


    /* Conjured Tests */
    // "Conjured" items degrade in Quality twice as fast as normal items
    @Test
    void conjuredItemShouldDecreaseQualityByTwo_whenSellInAboveZero(){
        // Arrange
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void conjuredItemShouldDecreaseQualityByFour_whenSellInZeroOrLess(){
        // Arrange
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 25) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(21, app.items[0].quality);

    }

    @Test
    void conjuredItemShouldNotDecreaseQualityBelowZero(){
        // Arrange
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 0) };
        GildedRose app = new GildedRose(items);

        // Act
        app.updateQuality();
        
        // Assert
        assertEquals(0, app.items[0].quality);
    }

}
