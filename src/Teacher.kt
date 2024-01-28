
class Teacher (
    var name: String,
    var course: Course?
){

    fun setTeacher(nm: String, crs: Course?){
        this.name = nm
        this.course = crs
    }

}