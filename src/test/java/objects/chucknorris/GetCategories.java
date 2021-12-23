package objects.chucknorris;

import java.util.Objects;

public class GetCategories {

    public String category;

    public GetCategories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetCategories)) return false;

        GetCategories that = (GetCategories) o;

        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return category != null ? category.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetCategories{" +
                "category='" + category + '\'' +
                '}';
    }
}
