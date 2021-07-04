package allexamples;


public class CustomHashMap<K, V> {


    int n = 1;
    private final Object[] map;

    CustomHashMap() {
        map = new Object[2];
    }

    private int getIndex(Object key) {
        return key.hashCode() & (n);
    }

    private boolean isSpaceAvailable() {
        if (map.length == n) {
            Object[] copiedArray = new Object[n+2];
            System.arraycopy(map, 0, copiedArray, 0, n);
            n+=2;
        }
        return true;
    }


    public void put(Object key, Object value) {
        if (isSpaceAvailable()) {
            map[getIndex(key)] = value;
            n++;
        }
    }

    public Object get(Object key) {
        return map[getIndex(key)];
    }


    public static void main(String[] args) {
        CustomHashMap<Object, Object> map = new CustomHashMap<>();
        map.put("test", 123);
        map.put("test", 123);
        map.put("xyz", 2345);
        System.out.println(map.get("xyz"));
    }


}
