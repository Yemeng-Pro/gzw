package 大厂笔试题;

public class 上海银行 {
    public int get_year_gap(float[] A, float[] B) {
        //GDP总量、GDP年增长率，各国人口、人口年增长率
        int result = 0;
        float A_gdp_rate = A[1];
        float A_people_rate = A[3];
        float A_GDP = A[0];
        float A_Humen = A[2];
        float B_gdp_rate = B[1];
        float B_people_rate = B[3];
        float B_GDP = B[0];
        float B_Humen = B[2];

        float A_GDP_average = A_GDP / A_Humen;
        float B_GDP_average = B_GDP / B_Humen;
        while (B_GDP_average < A_GDP_average) {
            result++;
            A_GDP = A_GDP*(1 + A_gdp_rate);
            B_GDP = B_GDP * (1 + B_gdp_rate);
            A_Humen = A_Humen * (1 + A_people_rate);
            B_Humen = B_Humen * (1 + B_people_rate);
            A_GDP_average = A_GDP / A_Humen;
            B_GDP_average = B_GDP / B_Humen;
        }
        return result;
    }
}
