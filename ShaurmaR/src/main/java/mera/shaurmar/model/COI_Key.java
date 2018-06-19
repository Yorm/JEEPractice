
package mera.shaurmar.model;

import java.io.Serializable;


public class COI_Key implements Serializable{
    private long ingredientId;
    private long compoundordId;

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public long getCompoundordId() {
        return compoundordId;
    }

    public void setCompoundordId(long compoundordId) {
        this.compoundordId = compoundordId;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.ingredientId ^ (this.ingredientId >>> 32));
        hash = 89 * hash + (int) (this.compoundordId ^ (this.compoundordId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final COI_Key other = (COI_Key) obj;
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        if (this.compoundordId != other.compoundordId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "COI_Key{" + "ingredientId=" + ingredientId + ", compoundordId=" + compoundordId + '}';
    }
    
    
}
