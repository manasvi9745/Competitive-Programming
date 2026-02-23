import java.io.*;
import java.util.*;

public class FestivalCrowdMo {

    static class Query {
        int l, r, idx;

        Query(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }

    static int BLOCK;
    static int[] freq;
    static int distinct = 0;

    static void add(int value) {
        freq[value]++;
        if (freq[value] == 1)
            distinct++;
    }

    static void remove(int value) {
        freq[value]--;
        if (freq[value] == 0)
            distinct--;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            queries[i] = new Query(l, r, i);
        }

        BLOCK = (int) Math.sqrt(n);

        Arrays.sort(queries, (a, b) -> {
            if (a.l / BLOCK != b.l / BLOCK)
                return Integer.compare(a.l / BLOCK, b.l / BLOCK);
            return Integer.compare(a.r, b.r);
        });

        // Coordinate compression
        int[] compressed = arr.clone();
        Arrays.sort(compressed);

        HashMap<Integer, Integer> map = new HashMap<>();
        int id = 0;
        for (int x : compressed) {
            if (!map.containsKey(x))
                map.put(x, id++);
        }

        for (int i = 0; i < n; i++)
            arr[i] = map.get(arr[i]);

        freq = new int[id];
        int[] answer = new int[q];

        int currL = 0, currR = -1;

        for (Query query : queries) {

            while (currR < query.r)
                add(arr[++currR]);

            while (currR > query.r)
                remove(arr[currR--]);

            while (currL < query.l)
                remove(arr[currL++]);

            while (currL > query.l)
                add(arr[--currL]);

            answer[query.idx] = distinct;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : answer)
            sb.append(x).append("\n");

        System.out.print(sb);
    }
}