package allexamples;

import java.util.*;

/*
* [
  {
    "name": "Accessories",
    "id": 1,
    "parent_id": 20,
  },
  {
    "name": "Watches",
    "id": 57,
    "parent_id": 1
  },
  {
    "name": "Men",
    "id": 20,
    "parent_id": null
  }
  *
  * [1-{}]
]
* result:
*
* [
  {
    "name": " Men",
    "id": 20,
    "parent_id": null
  },
  {
    "name": "Accessories",
    "id": 1,
    "parent_id": 20
  },
  {
    "name": "Watches",
    "id": 57,
    "parent_id": 1
  }
]
* */
public class FormatJson {

    public static List<Category> transform(List<Category> categories) {

        Map<String, Category> map = new HashMap<>();
        for (Category c : categories) {
            map.put(c.id, c);
        }


        Map<String, Category> result = new LinkedHashMap<>();
        for (Map.Entry<String, Category> entry : map.entrySet()) {
            Category c = entry.getValue();
            recur(map, c, result);
        }

        System.out.println(result);
        return null;
    }


    public static void recur(Map<String, Category> map, Category category, Map<String, Category> categories) {
        if (category == null) {
            return;
        }
        Category parent = map.get(category.parent_id);
        recur(map, parent, categories);
        categories.put(category.id, category);
    }

    public static void main(String[] args) {

        Category cat1 = new Category("Accessories", "1", "20");
        Category cat4 = new Category("Acc", "100", "1");
        Category cat2 = new Category("Watches", "57", "1");
        Category cat3 = new Category("Men", "20", null);
        List<Category> categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        List<Category> result = transform(categories);
        System.out.println(result);
    }


    public static class Category {
        String name;
        String id;
        String parent_id;
        Category parent;

        public Category(String name, String id, String parent_id) {
            this.name = name;
            this.id = id;
            this.parent_id = parent_id;
            this.parent = null;
        }

    }
}
