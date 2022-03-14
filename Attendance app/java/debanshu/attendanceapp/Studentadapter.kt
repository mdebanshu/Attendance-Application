package debanshu.attendanceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Studentadapter(private val studentlist: ArrayList<Studentlist>) : RecyclerView.Adapter<Studentadapter.StudentViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_item,
       parent,false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentitem = studentlist[position]

        holder.studentname.text = currentitem.studentName
        holder.studentfname.text = currentitem.sfName
        holder.studentmname.text = currentitem.smName
        holder.stdentmonu.text = currentitem.smNo
        holder.studentaddress.text = currentitem.saddress

    }

    override fun getItemCount(): Int {
        return studentlist.size
    }
    class StudentViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){

        val studentname:TextView = itemView.findViewById(R.id.tvsname)
        val studentfname:TextView = itemView.findViewById(R.id.tvsfname)
        val studentmname:TextView = itemView.findViewById(R.id.tvsmname)
        val stdentmonu:TextView = itemView.findViewById(R.id.tvsmnumber)
        val studentaddress:TextView = itemView.findViewById(R.id.tvsaddress)

    }
}