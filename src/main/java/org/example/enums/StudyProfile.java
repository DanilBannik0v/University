package org.example.enums;

public enum StudyProfile {
    INFORMATION_SYSTEMS_ADMINISTRATION("Администированрие информационных систем"),
    IT("Информатика"),
    ECONOMY("Экономика"),
    BUSINESS_INFORMATICS("Бизнесс информатика"),
    TOURISM("Туризм"),
    HOTEL_BUSINESS("Гостиничное дело"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика"),
    PHYSICS("Физика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return '\''+ profileName + '\'';
    }
}
