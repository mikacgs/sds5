import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { format } from "util";
import { BASE_URL } from "utils/requests";

function DataTable() {

   const [page, setPage] = useState<SalePage>({
      first: true,
      last: true,
      number: 0,
      totalElements: 0,
      totalPages: 0,
   })
   useEffect(() => {
      axios.get(`${BASE_URL}/sales?page=0&size=20&sort=date,desc`)
         .then(response => {
            setPage(response.data);
            // console.log(page);

         })
   }, [])

   return (
      <div className="table-responsive">
         <table className="table table-striped table-sm">
            <thead>
               <tr>
                  <th>Data</th>
                  <th>Vendedor</th>
                  <th>Clientes visitados</th>
                  <th>Negócios fechados</th>
                  <th>Valor</th>
               </tr>
            </thead>
            <tbody>
               {console.log(page)}
               {
                  page.content?.map(x => {
                    return (<tr key={x.id}>
                        <td>{format(x.date)}</td>
                        <td>{x.seller.name}</td>
                        <td>{x.visited}</td>
                        <td>{x.deals}</td>
                        <td>{x.amount.toFixed(2)}</td>
                     </tr>)
                  })
               }
            </tbody>
         </table>
      </div>
   );
}

export default DataTable;
