class ZigZag {

    static int longestZigZag(int arr[], int n) {
        int[][] zigzag = new int[n][2];

        for (int i = 0; i < n; i++) {
            zigzag[i][0] = zigzag[i][1] = 1;
        }

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && zigzag[i][0] < zigzag[j][1] + 1) {
                    zigzag[i][0] = zigzag[j][1] + 1;
                }
                if (arr[j] > arr[i] && zigzag[i][1] < zigzag[j][0] + 1) {
                    zigzag[i][1] = zigzag[j][0] + 1;
                }
            }
            maxLength = Math.max(maxLength, Math.max(zigzag[i][0], zigzag[i][1]));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 49, 50, 31, 60 };
        int n = arr.length;
        System.out.println("Length of Longest Zig-Zag subsequence is " + longestZigZag(arr, n));
    }
}
