class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                int p = files[i].indexOf('(');
                String key = files[i].substring(p);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(files[0] + "/" + files[i].substring(0, p));
                map.put(key, list);
            }
        }
        for (List<String> value : map.values()) {
            if (value.size() > 1) {
                result.add(value);
            }
        }
        return result;
        
    }
}