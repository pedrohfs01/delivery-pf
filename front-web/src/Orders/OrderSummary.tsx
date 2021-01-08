function OrderSummary() {
    return (
        <div className="order-summary-container">
            <div className="order-summary-content">
                <div>
                    <span className="amount-selected-container">
                        <strong className="amount-selected">2</strong>
                    Pedidos selecionados
                    </span>
                        <span className="order-summary-total">
                            <strong className="amount-selected">R$: 50,00</strong>
                        Valor total
                    </span>
                </div>
                <button className="order-summary-make-order">
                    Fazer pedido
                </button>
            </div>
        </div>
    );
}

export default OrderSummary;