package app.hook.archival.commons.requests;

import java.util.Date;

// TODO: validate startDate is less than endDate
public class ListMessageRequest {
    private Long startTimestamp;
    private Long endTimestamp;

    public ListMessageRequest() {}

    public ListMessageRequest(Long startTimestamp, Long endTimestamp) {
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public Long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public Date getStartDate() {
        return new Date(this.startTimestamp);
    }

    public Date getEndDate() {
        return new Date(this.endTimestamp);
    }
}
