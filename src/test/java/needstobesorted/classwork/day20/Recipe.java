package needstobesorted.classwork.day20;

import java.util.Arrays;

public class Recipe {

    public String recipename;
    public Ingridient[] ingredlist;
    public int preptime;

    public Recipe(String recipename, Ingridient[] ingredlist, int preptime) {
        this.recipename = recipename;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public Ingridient[] getIngredlist() {
        return ingredlist;
    }

    public void setIngredlist(Ingridient[] ingredlist) {
        this.ingredlist = ingredlist;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;

        Recipe recipe = (Recipe) o;

        if (preptime != recipe.preptime) return false;
        if (recipename != null ? !recipename.equals(recipe.recipename) : recipe.recipename != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(ingredlist, recipe.ingredlist);
    }

    @Override
    public int hashCode() {
        int result = recipename != null ? recipename.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(ingredlist);
        result = 31 * result + preptime;
        return result;
    }
}
