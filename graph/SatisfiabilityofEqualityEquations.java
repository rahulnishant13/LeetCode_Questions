// 990. Satisfiability of Equality Equations
// https://leetcode.com/problems/satisfiability-of-equality-equations/

class SatisfiabilityofEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int [] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for(String equation : equations){
            if(equation.charAt(1) == '='){
                int var1 = getParent(equation.charAt(0)-'a', parent);
                int var2 = getParent(equation.charAt(3)-'a', parent);

                parent[var2] = var1;
            }
        }

        for (String equation : equations) {
            if(equation.charAt(1) == '!'){
                int var1 = getParent(equation.charAt(0)-'a', parent);
                int var2 = getParent(equation.charAt(3)-'a', parent);

                if(var1 == var2){
                    return false;
                }
            }
        }

        return true;
    }

    private static int getParent(int child, int[] parent) {
        if(child == parent[child]){
            return child;
        }
        return getParent(parent[child], parent);
    }
}
