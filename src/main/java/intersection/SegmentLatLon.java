package intersection;

/**
 * @author MJL
 * @date 2023/12/28.
 */
public class SegmentLatLon {
    /**
     * 开始点的坐标
     */
    private LatLon startLatLon;
    /**
     * 结束点的坐标
     */
    private LatLon endLatLon;

    public SegmentLatLon(LatLon startLatLon, LatLon endLatLon) {
        this.startLatLon = startLatLon;
        this.endLatLon = endLatLon;
    }

    public SegmentLatLon() {
    }

    public LatLon getStartLatLon() {
        return startLatLon;
    }

    public void setStartLatLon(LatLon startLatLon) {
        this.startLatLon = startLatLon;
    }

    public LatLon getEndLatLon() {
        return endLatLon;
    }

    public void setEndLatLon(LatLon endLatLon) {
        this.endLatLon = endLatLon;
    }
}
