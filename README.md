# AI coding tools for Eclipse developers

There has been a lot of hype surrounding AI coding tools. So far there are two main categories of tool:

- Autocomplete tools, where GitHub Copilot is the best known brand.
- Chat tools where you copy-paste your existing code into a text box, ask the AI to do things to it (refactor, explain, add tests, etc.) and then copy the answers out. You can do this in a web browser, or there are IDE plugins to make the process easier and more powerful.

All of these categories of AI tooling are available to Eclipse users. As a quickstart, if you just clone this repo and then run `./gradlew equoIde` or `./mvnw equo-ide:launch` (depending on your preference), then you'll get an example project setup with all of the plugins that we are talking about, as well as some code to tinker with.

## Copilot

GitHub Copilot is not available for Eclipse right now, but [Tabnine](https://www.tabnine.com/) provides exactly the same concept. Compared to Copilot, Tabnine has the bonuses of a free tier and the option to self-host.

TODO: screenshot

You can install Tabnine from the [Eclipse marketplace](https://marketplace.eclipse.org/content/tabnine-ai-assistant-software-developers), but in this demo we are using [EquoIDE](https://github.com/equodev/equo-ide#quickstart) to handle installation.

If it's not working for you, make sure to click the <img src="images/tabnine-logo.png" height="16px">**Tabnine Starter** in the bottom right and login to your Tabnine account.

## ChatGPT (outside the IDE)

When it comes to chat-based tools, GPT-4 is currently far more useful than the other LLMs on the market. Especially as a beginner, GPT-4 gives fantastic results, whereas other models require more "prompt engineering" to get a useful result. For now, API access to GPT-4 is behind a long waitlist, but you can use GPT-4 through a [web interface](https://chat.openai.com/) right now as a ChatGPT Plus subscriber. If you can't afford $20 per month, you can still use GPT-3.5 for free and get useful results, as we'll  show below.

Let's start by asking ChatGPT-4 to convert this unit test from JUnit 5 to JUnit 4.

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CapabilityTest {
  @Test
  public void individualSubset() {
    var nameFoo = new Capability("ns", "name", "foo");
    var classBar = new Capability("ns", "class", "bar");
    Assertions.assertFalse(nameFoo.isSubsetOf(classBar));
    Assertions.assertFalse(classBar.isSubsetOf(nameFoo));
  }
}
```

To ask this question, the key things to remember are:

- `shift+enter` inserts a newline without submitting the prompt
- You should put code behind a ` ```java ` fence

Here's what that looks like.

<img src="images/gpt4-junit5-to-4.png" width="550px"/>


If you ask that same question using GPT-3.5 instead of GPT-4 (try it yourself!), you get almost the same answer, except:

- you don't get static imports
- it doesn't explain why it replaces `var` with the full explicit type `Capability`

In this case it's not a huge difference, but it demonstrates how GPT4 can do a much better job explaining itself. If you don't like the static assertions, just tell that to ChatGPT.

<img src="images/gpt4-junit5-to-4-no-static-import.png" width="450px"/>

### Things to ask

- Explain this code
- Generate unit tests for this code
- Refactor this code
- Write a class for me that does X

## ChatGPT (inside the IDE)

Looking at the screenshots above, you can see a few awkward things about this workflow. The most obvious is that you have to manually copy-paste a lot of text, and that text consumes a lot of screen space.

The second thing is that you're going to be asking it the same question over and over again "Write unit tests for this code using JUnit 5", etc. You also have to read a a fair bit of prose from ChatGPT, you might wish that it would just give you the code and no explanation.

If you do some googling around "Prompt engineering", you'll see suggestions to start every chat session with "You are an expert Java programmer" to put the LLM into the "right mood" for best generating your code. You can also say "respond only with code, do not provide commentary" if you prefer shorter answers.

To make this easier, there is the [Equo ChatGPT plugin](https://github.com/equodev/equo-ide-chatgpt) (which was inspired by the [AssistAI](https://github.com/gradusnikov/eclipse-chatgpt-plugin) plugin). It lets you use your ChatGPT account (free or Plus) to ask questions without all the boilerplate.

TODO