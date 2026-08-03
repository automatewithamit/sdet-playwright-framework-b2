package com.petstore.som.pet;

import java.util.List;

public class PetPostResponse {


        private long id;
        private Category category;
        private String name;
        private List<String> photoUrls;
        private List<Tag> tags;
        private String status;

        // No-argument Constructor
        public PetPostResponse() {}

        // Getters and Setters
        public long getId() { return id; }
        public void setId(long id) { this.id = id; }

        public Category getCategory() { return category; }
        public void setCategory(Category category) { this.category = category; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public List<String> getPhotoUrls() { return photoUrls; }
        public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }

        public List<Tag> getTags() { return tags; }
        public void setTags(List<Tag> tags) { this.tags = tags; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        // Nested Classes
        public static class Category {
            private int id;
            private String name;

            public Category() {}

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }

        public static class Tag {
            private int id;
            private String name;

            public Tag() {}

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }
    }

