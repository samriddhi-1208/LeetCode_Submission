class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s=new HashSet<>(wordList);
        if(!s.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int steps=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String word=q.poll();
                char[] arr=word.toCharArray();
                for(int j = 0;j<arr.length;j++){
                    char org=arr[j];

                    for(char c ='a';c<='z';c++){
                        arr[j]=c;
                        String newWord = new String(arr);
                        if(newWord.equals(endWord)) return steps+1;
                        if(s.contains(newWord)){
                            q.add(newWord);
                            s.remove(newWord);
                        }

                    }
                    arr[j]=org;
                }
            }
            steps++;
        }
return 0;
    }
}