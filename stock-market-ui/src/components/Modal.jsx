import { useState } from "react";
import { Alert, Button, Form, Modal } from "react-bootstrap";
import { post } from "../services/Api";

export default function StockModal({ show, onClose, data }) {
  const [name, setName] = useState(data.name);
  const [currentPrice, setCurrentPrice] = useState(data.price);
  const [error, setError] = useState("");
  const handleClose = () => {
    setName("");
    setCurrentPrice("");
    onClose(false);
  };
  const saveStock = async () => {
    const res = await post("stocks", { name, currentPrice });
    if (!res.error) {
      handleClose();
    } else {
      setError(res.error);
    }
  };
  return (
    <>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Stock Form</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Name</Form.Label>
              <Form.Control
                type="text"
                placeholder="name"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
              <Form.Text className="text-muted">
                Place the stock name you want to buy.
              </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
              <Form.Label>Price</Form.Label>
              <Form.Control
                type="text"
                value={currentPrice}
                placeholder="stock price"
                onChange={(e) => setCurrentPrice(e.target.value)}
              />
            </Form.Group>
          </Form>
          {error ? <Alert variant="danger">{error}</Alert> : ""}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={saveStock}>
            Save
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
