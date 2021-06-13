import "./App.css";
import { useState, useEffect } from "react";
import StockList from "../components/StockList";
import { get } from "../services/Api";
import { Button, Jumbotron } from "react-bootstrap";
import StockModal from "../components/Modal";

function App() {
  const [stockList, setStockList] = useState([]);
  const [show, setShow] = useState(false);
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
    setShow(show);
  };
  return (
    <div className="main">
      <StockModal
        data={{ name: "", price: "" }}
        show={show}
        onClose={handleCloseModal}
      ></StockModal>
      <Jumbotron>
        <h1>Stock Market</h1>
        <p>Stock information, create new </p>
        <StockList stocks={stockList}></StockList>
        <Button onClick={() => addStock()}>Add</Button>
      </Jumbotron>
    </div>
  );
}

export default App;
