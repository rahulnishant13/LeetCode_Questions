// 2115. Find All Possible Recipes from Given Supplies
// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

// using topological sort 
class FindAllPossibleRecipesfromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> recipeMap = new HashMap<>();
        Map<String, Integer> degreeMap = new HashMap<>();
        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

        for(int i=0; i<recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingredientList = ingredients.get(i);
            for(String ing : ingredientList){
                recipeMap.putIfAbsent(ing, new ArrayList<>());
                recipeMap.get(ing).add(recipe);
                degreeMap.put(ing, degreeMap.getOrDefault(ing, 0));
            }
            degreeMap.put(recipe, ingredientList.size());
        }

        Queue<String> recipeQueue = new LinkedList<>();

        for(Map.Entry<String, Integer> entrySet : degreeMap.entrySet()) {
            if(entrySet.getValue() == 0)
                recipeQueue.offer(entrySet.getKey());
        }

        List<String> result = new ArrayList<>();

        while(!recipeQueue.isEmpty()) {
            String node = recipeQueue.poll();
            if(!supplySet.contains(node)) {
                continue;
            } else {
                if(recipesSet.contains(node)) {
                    result.add(node);
                }
            }

            if(recipeMap.containsKey(node)) {
                for (String child : recipeMap.get(node)) {
                    degreeMap.put(child, degreeMap.get(child) - 1);
                    if(degreeMap.get(child) == 0) {
                        recipeQueue.offer(child);
                        supplySet.add(child);
                    }
                }
            }
        }

        return result;

    }
}


// ============================= using topological sort  ============================================

