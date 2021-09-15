package mgkportlet.rest.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import mgkportlet.rest.client.dto.v1_0.Person;
import mgkportlet.rest.client.json.BaseJSONParser;

/**
 * @author USER
 * @generated
 */
@Generated("")
public class PersonSerDes {

	public static Person toDTO(String json) {
		PersonJSONParser personJSONParser = new PersonJSONParser();

		return personJSONParser.parseToDTO(json);
	}

	public static Person[] toDTOs(String json) {
		PersonJSONParser personJSONParser = new PersonJSONParser();

		return personJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Person person) {
		if (person == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (person.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(person.getEmail()));

			sb.append("\"");
		}

		if (person.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(person.getFirstName()));

			sb.append("\"");
		}

		if (person.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(person.getId());
		}

		if (person.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(person.getLastName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PersonJSONParser personJSONParser = new PersonJSONParser();

		return personJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Person person) {
		if (person == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (person.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(person.getEmail()));
		}

		if (person.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(person.getFirstName()));
		}

		if (person.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(person.getId()));
		}

		if (person.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put("lastName", String.valueOf(person.getLastName()));
		}

		return map;
	}

	public static class PersonJSONParser extends BaseJSONParser<Person> {

		@Override
		protected Person createDTO() {
			return new Person();
		}

		@Override
		protected Person[] createDTOArray(int size) {
			return new Person[size];
		}

		@Override
		protected void setField(
			Person person, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					person.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					person.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					person.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					person.setLastName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}