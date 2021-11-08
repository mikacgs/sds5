import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

function DonutChart() {

   useEffect(() => {
      axios.get(`${BASE_URL}/sales/amount-by-seller`)
         .then((response) => {

            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            setchartData({ labels: myLabels, series: mySeries })
         })
         .catch(() => {

         })
   }, [])

   type ChartData = {
      labels: string[];
      series: number[];
   }
   const [chartData, setchartData] = useState<ChartData>({ series: [], labels: [] })



   // const mockData = {
   //    series: [477138, 499928, 444867, 220426, 473088],
   //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
   // }

   const options = {
      legend: {
         show: true
      }
   }

   return (
      <Chart
         options={{ ...options, labels: chartData.labels }}
         series={chartData.series}
         type="donut"
         height="240"
      />);

}

export default DonutChart;
