
/**
 A interface Listener define um contrato para objetos que desejam
 ser notificados sobre eventos de transação ou outras atualizações
 dentro do sistema.

 Implementações dessa interface devem fornecer um mecanismo para
 lidar com eventos que são disparados, permitindo uma abordagem
 de programação orientada a eventos.

 @author Professor Cancian
 @version 1.0
 @since 2024
 */
public interface Listener {

	/**
	 Atualiza o listener com um evento que ocorreu no sistema.

	 @param event O evento que ocorreu, representado como um objeto
	 que implementa a interface ListenEvent.
	 */
	void update(ListenEvent event);
}
