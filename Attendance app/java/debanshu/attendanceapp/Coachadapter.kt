package debanshu.attendanceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Coachadapter(private val coachList: ArrayList<Coachlist>) : RecyclerView.Adapter<Coachadapter.Coachviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Coachadapter.Coachviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.coach_item,
            parent,false)
        return Coachviewholder(itemView)
    }

    override fun onBindViewHolder(holder: Coachadapter.Coachviewholder, position: Int) {
        val currentitem = coachList[position]

        holder.coachname.text = currentitem.coachname
        holder.coachfName.text = currentitem.coachfName
        holder.coachmName.text = currentitem.coachmName
        holder.coachmNo.text = currentitem.coachmNo
        holder.coachaddress.text = currentitem.coachaddress

    }

    override fun getItemCount(): Int {
        return coachList.size
    }
    class Coachviewholder(itemView :View) : RecyclerView.ViewHolder(itemView){

        val coachname:TextView = itemView.findViewById(R.id.tvcname)
        val coachfName:TextView = itemView.findViewById(R.id.tvcfname)
        val coachmName:TextView = itemView.findViewById(R.id.tvcmname)
        val coachmNo:TextView = itemView.findViewById(R.id.tvcmnumber)
        val coachaddress:TextView = itemView.findViewById(R.id.tvcaddress)

    }

}