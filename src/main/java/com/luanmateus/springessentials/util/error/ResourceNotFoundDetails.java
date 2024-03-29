package com.luanmateus.springessentials.util.error;

import lombok.Getter;

@Getter
public class ResourceNotFoundDetails extends ErrorDetails {

    public static final class Builder {
        private String title;
        private Integer status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();

            resourceNotFoundDetails.setDeveloperMessage(this.developerMessage);
            resourceNotFoundDetails.setTimestamp(this.timestamp);
            resourceNotFoundDetails.setDetail(this.detail);
            resourceNotFoundDetails.setTitle(this.title);
            resourceNotFoundDetails.setStatus(this.status);

            return resourceNotFoundDetails;
        }
    }
}
