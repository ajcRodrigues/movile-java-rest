# movile-java-rest
## Biblioteca Java para API Movile Messaging
###### Envio de SMS


```java
MovileConfiguration movileConf = new MovileConfiguration("USER_NAME", "AUTH_TOKEN");

try {
	String response = new MovileService(movileConf).send(new Message("cellphone", "Message\nof SMS"));
	
	// Retorna ID do SMS (Returns the ID of SMS)
	System.out.println(response);
}
catch (IException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
```
