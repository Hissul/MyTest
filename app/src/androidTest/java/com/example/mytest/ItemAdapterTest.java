package com.example.mytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ItemAdapterTest {
    private ItemAdapter adapter;
    private List<String> itemList;

    @Before
    public void setUp() {
        itemList = Arrays.asList("Apple", "Banana", "Orange", "Grape", "Watermelon");
        adapter = new ItemAdapter(itemList);
    }

    @Test
    public void filter_emptyQuery_returnsAllItems() {
        adapter.filter("");
        assertEquals(itemList.size(), adapter.getItemCount());
    }

    @Test
    public void filter_nullQuery_returnsAllItems() {
        adapter.filter(null);
        assertEquals(itemList.size(), adapter.getItemCount());
    }

    @Test
    public void filter_validQuery_returnsFilteredItems() {
        adapter.filter("ap");
        assertEquals(2, adapter.getItemCount()); // "Apple", "Grape"
    }

    @Test
    public void filter_noMatch_returnsNoItems() {
        adapter.filter("xyz");
        assertEquals(0, adapter.getItemCount());
    }
}