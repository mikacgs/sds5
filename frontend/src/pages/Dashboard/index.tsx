import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import Navbar from "components/Navbar";

function Dashboard() {
   return (
      <>
      <Navbar></Navbar>
      <div className="container">
         <h1 className="text-primary py-3">Dashboard de vendas</h1>
         <div className="row px-3">
            <div className="col-sm-6">
               <h5 className="text-center text-secondary">Taxa de conversão (%)</h5>
               <BarChart />
            </div>
            <div className="col-sm-6">
               <h5 className="text-center text-secondary">Taxa de conversão (%)</h5>
               <DonutChart />
            </div>
         </div>
         <div className="py-3">
            <h2 className="text-primary">Todas vendas</h2>
            <DataTable />
         </div>
        
      </div>
      <Footer></Footer>
      </>
   );
}

export default Dashboard;