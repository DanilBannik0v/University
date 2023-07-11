package org.example;

public enum StudyProfile {
    INFORMATIONSYSTEMSADMINISTRATION("Администированрие информационных систем"),
    IT("Информатика"),
    ECONOMY("Экономика"),
    BUSINESSINFORMATICS("Бизнесс информатика"),
    TOURISM("Туризм"),
    HOTELBUSINESS("Гостиничное дело"),
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
