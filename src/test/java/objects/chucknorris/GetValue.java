package objects.chucknorris;

import java.util.Arrays;
import java.util.Objects;

public class GetValue {

    public int id;
    public String joke;
    public GetCategories[] categories;

    public GetValue(int id, String joke, GetCategories[] categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public GetCategories[] getCategories() {
        return categories;
    }

    public void setCategories(GetCategories[] categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetValue)) return false;

        GetValue getValue = (GetValue) o;

        if (id != getValue.id) return false;
        if (!Objects.equals(joke, getValue.joke)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(categories, getValue.categories);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (joke != null ? joke.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(categories);
        return result;
    }

    @Override
    public String toString() {
        return "GetValue{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }
}
