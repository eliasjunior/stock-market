import "./App.css";
import { useState, useEffect } from "react";
import StockList from "../components/StockList";
import { get } from "../services/Api";
import { Button, Jumbotron } from "react-bootstrap";
import StockModal from "../components/StockModal";

function App() {
  const [stockList, setStockList] = useState([]);
  const [show, setShow] = useState(false);
  const [currentStock, setCurrentStock] = useState({});
  const addStock = () => setShow(true);

  useEffect(() => {
    fetchStocks();
  }, [show]);
  async function fetchStocks() {
    try {
      const list = await get("stocks");
      setStockList(list);
    } catch (err) {
      console.error(err);
    }
  }
  const handleCloseModal = (show) => {
    setCurrentStock({});
    setShow(show);
  };
  const handleStockUpdate = async (stock) => {
    setCurrentStock(stock);
    setShow(true);
  };
  return (
    <div className="main">
      <StockModal
        data={currentStock}
        show={show}
        onClose={handleCloseModal}
      ></StockModal>
      <Jumbotron>
        <h1>Stock Market</h1>
        <p>Stock information </p>
        <StockList stocks={stockList} onUpdate={handleStockUpdate}></StockList>
        <Button onClick={() => addStock()}>Add</Button>
      </Jumbotron>
    </div>
  );
}

export default App;
