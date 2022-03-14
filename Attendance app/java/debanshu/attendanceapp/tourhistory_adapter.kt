package debanshu.attendanceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class tourhistory_adapter(private val tourlist: ArrayList<Reportlist>) : RecyclerView.Adapter<tourhistory_adapter.tourviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tourhistory_adapter.tourviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tourhistory_item,
            parent,false)
        return tourviewholder(itemView)
    }


    override fun onBindViewHolder(holder: tourviewholder, position: Int) {
        val currentitem = tourlist[position]

        holder.sportname.text = currentitem.sportname
        holder.coordinatorname.text = currentitem.coordinatorname
        holder.Coachname.text = currentitem.Coachname
        holder.coachmNo.text = currentitem.coachmNo
        holder.winner.text = currentitem.winner

    }

    override fun getItemCount(): Int {
        return tourlist.size    }
    class tourviewholder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val sportname: TextView = itemView.findViewById(R.id.tvsportname)
        val coordinatorname: TextView = itemView.findViewById(R.id.tvcoordinatorname)
        val Coachname: TextView = itemView.findViewById(R.id.tvcoachname)
        val coachmNo: TextView = itemView.findViewById(R.id.tvcoachnumber)
        val winner: TextView = itemView.findViewById(R.id.tvwinner)

    }

}