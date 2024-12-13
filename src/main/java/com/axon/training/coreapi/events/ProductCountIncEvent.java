package com.axon.training.coreapi.events;

import java.util.Objects;

public class ProductCountIncEvent {

    private final Integer count;


    public ProductCountIncEvent(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ProductCountIncEvent{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCountIncEvent that = (ProductCountIncEvent) o;
        return Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
