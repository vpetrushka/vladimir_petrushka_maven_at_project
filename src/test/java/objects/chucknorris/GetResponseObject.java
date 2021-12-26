package objects.chucknorris;

import java.util.Arrays;
import java.util.Objects;

public class GetResponseObject {

   public String type;
   public GetValue[] value;

   public GetResponseObject(String type, GetValue[] value) {
      this.type = type;
      this.value = value;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public GetValue[] getValue() {
      return value;
   }

   public void setValue(GetValue[] value) {
      this.value = value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof GetResponseObject)) return false;

      GetResponseObject that = (GetResponseObject) o;

      if (!Objects.equals(type, that.type)) return false;
      // Probably incorrect - comparing Object[] arrays with Arrays.equals
      return Arrays.equals(value, that.value);
   }

   @Override
   public int hashCode() {
      int result = type != null ? type.hashCode() : 0;
      result = 31 * result + Arrays.hashCode(value);
      return result;
   }

   @Override
   public String toString() {
      return "GetResponseObject{" +
              "type='" + type + '\'' +
              ", value=" + Arrays.toString(value) +
              '}';
   }
}
